function first() {
    return new Promise(function (resolve, reject) {
        var sum = 0

        for (var i = 0; i <= 100000000; i++) {
            sum += (i * 0.000000001) * Math.sin(i * Math.PI / 180.0)
        }

        resolve(sum)
    })
}

function second() {
    return new Promise(function (resolve, reject) {
        var sum = 0

        for (var i = 0; i <= 100000000; i++) {
            sum += (i * 0.00000001) * Math.cos(i * Math.PI / 90.0)
        }

        resolve(sum)
    })
}

function third() {
    return new Promise(function (resolve, reject) {
        var sum = 0

        for (var i = 0; i <= 100000000; i++) {
            sum += (i * 0.0000001) * Math.sin(i * Math.PI / 270.0)
        }

        resolve(sum)
    })
}

function fourth() {
    return new Promise(function (resolve, reject) {
        var sum = 0

        for (var i = 0; i <= 100000000; i++) {
            sum += (i * 0.000001) * Math.cos(i * Math.PI / 240.0)
        }

        resolve(sum)
    })
}

// 특성이 몇 개 있다.
// 1) 자바스크립트 엔진이 파악하기에 분리가 가능한 수학 연산
// 2) 행렬 연산, 벡터 연산(웹 게임 분야)

// 수학 연산의 경우는
// 애초 자바스크립트가 스레드 기반으로 돌아가기에
// Promise 사용 유무에 따라 별 차이가 없다
// 수동으로 컨트롤해줄 필요성이 있기 때문에 존재
// ex. DB, 웹 크롤링 등등
async function asyncProcess() {
    const res = await Promise.all(
        [
            first(),
            second(),
            third(),
            fourth()
        ]
    )

    console.log(res)
}

asyncProcess()

const TestPromiseVersion = () => {
    console.log("TestPromiseVersion Start")

    console.log("TestPromiseVersion End")

    return (
        <div className="TestPromiseVersion">
            <p>TestPromiseVersion</p>
        </div>
    )
}

export default TestPromiseVersion