// 연습 문제 : 팀 로또 ?!
// 참가자는 총 1000명이다.
// 참가자는 이 로또 배틀에 참여하기 위해 각자 1000만 원을 지불한다.
// 참가자들은 1 ~ 10000 사이의 숫자를 할당 받는다.
// 팀원은 랜덤하게 4명씩 짝을 짓는다. (총 250개의 팀)
// 로또 당첨은 1013의 배수를 뽑은 사람이 이긴 것으로 간주한다.

// 배당금은 아래 원칙에 따라 지급한다.
// 모든 팀원이 로또에 당첨된 경우 : 승리 수당 배수가 2^4으로 16배 뛴다.
// 팀원 중 3명이 당첨된 경우 : 승리 수당 배수가 2^3으로 8배 뛴다.
// 팀원 중 2명이 당첨된 경우 : 승리 수당 배수가 2^2으로 4배 뛴다.
// 팀원 중 1명이 당첨된 경우 : 원래 수당 그대로 받는다.

// 1) 16 : 16 : 8 : 8 : 4 : 1 : 1 : 1 : 1 : 1 : 1 : 1 : 1 : 1
// 2) 16
// 3) 8
// 4) 4
// 5) 1

// 주최 측은 무조건적으로 전체 비용의 33%를 가져간다.
// 승리 팀의 상태를 출력하고 승리 수당을 분배하여 표시하도록 한다.
const AllocRandomNumber = (arr) => {
    console.log("AllocRandomNumber Called")

    for (var i = 0; i < arr.length; i++) {
        arr[i] = Math.floor(Math.random() * 10000) + 1
    }
}

const CreateRandomTeam = (arr, num) => {
    console.log("CreateRandomTeam Called")

    const ERROR = -1

    let randNum
    let range = arr.length / num

    // 1번째 실수 : i, j의 순서를 혼동하여 거꾸로 적음
    //            250 * 0 ~ 3 + 0 ~ 3 ===> 0 ~ 3, 250 ~ 253, 500 ~ 503, 750 ~ 753
    // 2번째 실수 : 인덱싱을 잘못했다는 것을 생각하지 않고 내부에 또 루프를 만듦
    
    // Sol : 현재 아래 코드가 실수한 부분을 수정한 코드

    // 같은 팀원들에게 같은 숫자를 부여하겠다는 의미 (250개가 나오니까)
    for (var i = 0; i < range; ) {   // 250
        // 1번 팀, 2번 팀, 3번 팀 ...
        randNum = Math.floor(Math.random() * 250) + 1

        if (arr.indexOf(randNum) == ERROR) {
            for (var j = 0; j < num; j++) {   // 4

                // 전략
                // 1) 그냥 다 검사해서 집어넣기
                //    모든 검사를 수행하므로 속도가 느려짐
                //    반면 팀원들은 인접하지 않은 상태로 배치됨
                // 2) 검사는 단순화 하고 for 문을 한 번 더 돌자 !
                //    (내부에 4개짜리 루프를 돌린다)
                //    팀원끼리 인접해 있게 됨

                // 0 ~ 999 ---> i, j로 표현하는 방법에 대한 고민이 필요
                // j = 0 ~ 3
                // i = 0 ~ 250
                // i * range + j
                arr[i * num + j] = randNum
            }

            i++
        }
    }
}

const CheckWinner = (arr, winArr) => {
    const CRITERIA = 1013
    // const CRITERIA = 2

    for (var i = 0; i < arr.length; i++) {
        if (!(arr[i] % CRITERIA)) {
            winArr[i] = 1
        } else {
            winArr[i] = 0
        }
    }
}

Array.prototype.arrDivide = function (num) {
    let arr = this
    let len = arr.length
    // 딱 떨어지는 경우엔 floor OK
    // 나머지가 존재할 경우 ceil 올림으로 처리하면 될 듯 ?
    let cnt = Math.ceil(len / num)

    let newArr = []

    for (var i = 0; i < cnt; i++) {
        newArr.push(arr.splice(0, num))
    }

    return newArr
}

Array.prototype.printArr = function (num) {
    let arr = this
    let len = arr.length

    for (var i = 0; i < len; i += num) {
        console.log(arr[i], arr[i + 1], arr[i + 2], arr[i + 3])
    }
}

const CalcDividend = (teamArr, winArr, price) => {
    const ALL = 16
    const THREEFOUR = 8
    const TWOFOUR = 4
    const ZERO = 0

    const TEAMMEMNUM = 4

    // filter, every
    let divWinArr = winArr.arrDivide(TEAMMEMNUM)

    let teamNum = divWinArr.length
    let allClearRateArr = new Array(teamNum)
    let subClearRateArr = new Array(teamNum)

    for (var i = ZERO; i < teamNum; i++) {
        allClearRateArr[i] = divWinArr[i].every(allClear)
        subClearRateArr[i] = divWinArr[i].reduce(subClear)
    }

    function allClear(value) {
        return value > ZERO
    }

    function subClear(total, value) {
        return total + value
    }

    console.log('All Clear Team: ' + allClearRateArr)
    console.log('Sub Clear Team: ' + subClearRateArr)

    // For Debugging
    // divWinArr.printArr(TEAMMEMNUM)
    // console.log("divWinArr = " + divWinArr)

    // 현재까지 체크된 것이 배당금 16배수인 팀을 확보함
    // 배당금 8배, 4배, 1배인 팀도 확보한 상태
    // 전체 상금을 몇 등분 할지에 대한 계산이 필요하다.
    let dividendRate = allClearRateArr.reduce(checkTrueNum)

    function checkTrueNum(total, value) {
        if (value == true) {
            return total + ALL
        } else {
            return total
        }
    }

    console.log("All Clear Divdiend Rate = " + dividendRate)

    dividendRate += subClearRateArr.reduce(allSum)

    function allSum(total, value) {
        return total + value
    }

    console.log("Total Dividend Rate = " + dividendRate)

    let dividend = Math.round(price / dividendRate)

    console.log("1배수 배당금은 " + dividend + "입니다.")
    console.log("인당 배당금은 " +
        Math.round(dividend / TEAMMEMNUM) + "입니다.")

    console.log("4배수 배당금은 " + TWOFOUR * dividend + "입니다.")
    console.log("인당 배당금은 " +
        Math.round(TWOFOUR * dividend / TEAMMEMNUM) + "입니다.")
    
    console.log("8배수 배당금은 " + THREEFOUR * dividend + "입니다.")
    console.log("인당 배당금은 " +
        Math.round(THREEFOUR * dividend / TEAMMEMNUM) + "입니다.")
    
    console.log("16배수 배당금은 " + ALL * dividend + "입니다.")
    console.log("인당 배당금은 " +
        Math.round(ALL * dividend / TEAMMEMNUM) + "입니다.")
}

const Prob = () => {
    const MAXTEAMNUM = 4
    const NUMOFPERSON = 1000
    const FEE = 10000000
    const PARTICIPANTSTAKE = 0.67
    const PRICE = NUMOFPERSON * FEE * PARTICIPANTSTAKE

    console.log("상금 = " + PRICE)

    let arr = new Array(NUMOFPERSON)
    let teamArr = new Array(NUMOFPERSON)
    let WinnerArr = new Array(NUMOFPERSON)

    AllocRandomNumber(arr)
    console.log("After AllocRandomNumber() = " + arr)

    CreateRandomTeam(teamArr, MAXTEAMNUM)
    console.log("After CreateRandomTeam() = " + teamArr)

    CheckWinner(arr, WinnerArr)
    console.log("After CheckWinner() = " + WinnerArr)

    CalcDividend(teamArr, WinnerArr, PRICE)
    console.log("팀 로또가 성공적으로 마무리 되었습니다.")
    console.log("다음에도 잘 부탁드립니다 호갱님 ^^")

    return (
        <div className="Prob">
            <p>Prob</p>
        </div>
    )
}

export default Prob