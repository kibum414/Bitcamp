// 2번 문제에서 중복을 허용하지 않고 5의 배수만 골라보자!
// 또한 고른 값들은 모두 내림차순으로 정렬되어야 할 것이다.

const TodayHomework3 = () => {
    const RANGE = 50
    const ZERO = 0
    const MINUSONE = -1

    class nonDupRandomArr {
        constructor(num, mulNum) {
            this.arr = []
            this.pickArr = []
            this.num = num
            this.mulNum = mulNum
        }

        setArr() {
            for (var i = ZERO; i < this.num; ) {
                let arrNum = parseInt(Math.random() * RANGE)

                if (this.arr.indexOf(arrNum) === MINUSONE) {
                    this.arr.push(arrNum)
                    i++
                }
            }

            console.log("배열 : " + this.arr)
        }
        getArr() {
            return this.pickArr
        }
        pickMul() {
            this.pickArr = []

            for (var i = ZERO; i < this.num; i++) {
                if (this.arr[i] % this.mulNum === ZERO
                    && this.arr[i] !== ZERO) {
                    
                    this.pickArr.push(this.arr[i])
                }
            }

            console.log(`${this.mulNum}의 배수 : ` + this.pickArr)
        }
        sortArr(pickArr) {
            let sortedArr = pickArr.sort((a, b) => b - a)

            console.log("정렬 후 : " + sortedArr)
        }
    }

    let ndra = new nonDupRandomArr(10, 5)
    ndra.setArr()
    ndra.pickMul()
    ndra.sortArr(ndra.getArr())

    return (
        <div className="TodayHomework3">
            <p>
                Today's Homework 3
            </p>
        </div>
    )
}

export default TodayHomework3