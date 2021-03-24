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

// 랜덤으로 해서 팀 설정
// 1013의 배수 찾기 -> 각 팀별 몇 명인지 구하기
// 승리 수당 배수 합칠 때 reduce 사용
const AllocRandomNumber = (arr) => {
    console.log("AllocRandomNumber Called")
    for (var i = 0; i < arr.length; i++) {
        arr[i] = Math.floor(Math.random() * 10000) + 1
    }
}

const CreateRandomTeam = (arr, randArr) => {
    let indexArr = []
    let index

    for (var i = 0; i < arr.length;) {
        index = Math.floor(Math.random() * arr.length)

        if (!indexArr.includes(index)) {
            indexArr.push(index)

            randArr[i] = arr[index]
            i++
        }
    }

    return indexArr
}

const CheckWinner = (randArr, teamArr, winningnumber) => {
    let arrNum = 0
    let personperteam = 4
    let team = []

    //for (var i = 0; i < randArr.length; i++) {
    team[0] = randArr.slice(0, 4)
    team[1] = randArr.slice(4, 8)
    team = team.join("/")
    //}
    console.log("team : " + team)

    for (var i = 0; i < randArr.length; i++) {
        if (i % 4 === 0 && i !== 0) {
            arrNum++
        }

        if (randArr[i] % winningnumber === 0) {
            teamArr[arrNum]++
        }
    }

    for (var i = 0; i < teamArr.length; i++) {
        if (teamArr[i] > 0) {
            console.log(`${i + 1}팀 : ${teamArr[i]}명 당첨`)
        }
    }
}

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
const CalcDividend = (teamArr, indexArr, price) => {
    let numOfWinner = teamArr.reduce((total, value) => total + value)
    let dividend = parseInt(price / numOfWinner)
    let winnerPrice

    let announcement = () => {
        return console.log((i + 1) + "팀 " + indexArr[i] + "번 참가자 : " + winnerPrice + "원 당첨 !")
    }

    console.log("총 당첨자 수 : " + numOfWinner + "명")

    if (numOfWinner === 0) {
        console.log("당첨자가 없습니다.")
    } else {
        console.log(`승리 수당 : ${dividend}원`)
        for (var i = 0; i < teamArr.length; i++) {
            if (teamArr[i] === 4) {
                winnerPrice = dividend * Math.pow(2, 4)
                announcement()
            } else if (teamArr[i] === 3) {
                winnerPrice = dividend * Math.pow(2, 3)
                announcement(i, winnerPrice)
            } else if (teamArr[i] === 2) {
                winnerPrice = dividend * Math.pow(2, 2)
                announcement(i, winnerPrice)
            } else if (teamArr[i] === 1) {
                winnerPrice = dividend
                announcement()
            }
        }
    }
}

const Exercise1 = () => {
    const NUMOFPERSON = 12
    const FEE = 10000000
    const PARTICIPANTSTAKE = 0.67
    const PRICE = NUMOFPERSON * FEE * PARTICIPANTSTAKE
    const PERSONPERTEAM = 4
    const NUMOFTEAM = NUMOFPERSON / PERSONPERTEAM
    const WINNINGNUMBER = 10

    const RANGE = 10000
    const ZERO = 0
    const ONE = 1

    let participant = []
    let participantIndex = []
    let team = []
    let winnerIndex = []
    let winnerNumOfTeam = []
    let winnerNumOfTeamIndex = []

    console.log("상금 = " + PRICE)

    function AllocRandomNumber() {
        for (var i = ZERO; i < NUMOFPERSON; i++) {
            participant[i] = Math.floor(Math.random() * RANGE) + ONE
            participantIndex[i] = i + 1
        }
    }

    function CreateRandomTeam() {
        function sortFunc(arr, index) {
            for (var i = arr.length - 1; i > 0; i--) {
                var j = Math.floor(Math.random() * (i + 1))

                var temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp

                var temp2 = index[i]
                index[i] = index[j]
                index[j] = temp2
            }
        }

        sortFunc(participant, participantIndex)

        for (var i = ZERO; i < NUMOFTEAM; i++) {
            team[i] = participant.slice(PERSONPERTEAM * i, PERSONPERTEAM * (i + 1))
        }

        console.log(team)
        console.log(participantIndex)
    }

    function CheckWinner() {
        let cnt = ZERO
        let indexCnt = ZERO

        for (var i = ZERO; i < NUMOFTEAM; i++) {
            for (var j of team[i]) {
                if (j % WINNINGNUMBER === ZERO) {
                    winnerIndex.push(PERSONPERTEAM * i + indexCnt)
                    cnt++
                }
                indexCnt++
            }

            if (cnt) {
                winnerNumOfTeamIndex.push(i + 1)
            }

            winnerNumOfTeam[i] = cnt
            cnt = ZERO
            indexCnt = ZERO
        }
    }

    function CalcDividend() {
        let winnerTeam = winnerNumOfTeam.filter(function (num) {
            return num > ZERO
        })
        console.log("팀 당 당첨자 수 (최소 한 명) : " + winnerTeam)

        let numOfWinner = winnerTeam.reduce((total, value) => total + value, ZERO)
        console.log("총 당첨자 수 : " + numOfWinner)

        let mul = winnerTeam.map(cnt => {
            if (cnt === 1) {
                return 1
            } else {
                return Math.pow(2, cnt)
            }
        })

        if (numOfWinner === ZERO) {
            console.log("당첨자가 없습니다.")
        } else {
            let devidend = PRICE / numOfWinner
            console.log("승리 수당 : " + devidend)

            // 끝까지 안 돎 (winnerTeam 크기만큼만 돌아서)
            for (var i = ZERO; i < winnerTeam.length; i++) {
                let winnerPrice = devidend * mul[i]

                for (var j = ZERO; j < PERSONPERTEAM; j++) {
                    console.log(i * PERSONPERTEAM + j)

                    if (winnerIndex.includes(i * PERSONPERTEAM + j)) {
                        console.log(participantIndex[i * PERSONPERTEAM + j] + "번 참가자 (" +
                            winnerNumOfTeamIndex[i] + "팀) : " + winnerPrice + "원 당첨 !")
                    }
                }
            }
        }
    }

    AllocRandomNumber()
    console.log("섞기 전 참가자 할당 숫자 : " + participant)

    CreateRandomTeam()
    console.log("섞은 후 참가자 할당 숫자 : " + team)

    CheckWinner()
    console.log("팀 당 당첨자 수 : " + winnerNumOfTeam)
    console.log("당첨자 포함된 팀 번호 : " + winnerNumOfTeamIndex)
    console.log("당첨자 인덱스 : " + winnerIndex)

    CalcDividend()

    /*
    let arr = new Array(NUMOFPERSON)
    let randArr = new Array(NUMOFPERSON)
    let teamArr = new Array(NUMOFTEAM).fill(0)

    AllocRandomNumber(arr)
    console.log("res = " + arr)

    let indexArr = CreateRandomTeam(arr, randArr)
    console.log("rand res = " + randArr)
    console.log(indexArr)

    CheckWinner(randArr, teamArr, WINNINGNUMBER)
    console.log(teamArr)

    CalcDividend(teamArr, indexArr, PRICE)
    */

    return (
        <div className="Exercise1">
            <p>Exercise1</p>
        </div>
    )
}

export default Exercise1