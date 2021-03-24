// 자바스크립트 배열에 랜덤한 숫자를 n개 생성한다.
// n개의 배열에서 3의 배수만 골라보도록 하자 !
// (이 문제는 중복을 허용한다)

const TodayHomework2 = () => {
    const RANGE = 50
    const ZERO = 0

    class randArr {
        constructor(num, mulNum) {
            this.arr = []
            this.num = num
            this.mulNum = mulNum
        }
        
        setArr() {
            for (var i = ZERO; i < this.num; i++) {
                let arrNum = parseInt(Math.random() * RANGE)

                this.arr.push(arrNum)
            }

            console.log("배열 : " + this.arr)
        }

        pickMul() {
            let pickArr = []

            for (var i = ZERO; i < this.num; i++) {
                if (this.arr[i] % this.mulNum === ZERO
                    && this.arr[i] !== ZERO) {
                    
                    pickArr.push(this.arr[i])
                }
            }

            console.log(`${this.mulNum}의 배수 : ` + pickArr)
        }
    }
    
    let ra = new randArr(10, 3)
    ra.setArr()
    ra.pickMul()

    return (
        <div className="TodayHomework2">
            <p>
                Today's Homework 2
            </p>
        </div>
    )
}

export default TodayHomework2