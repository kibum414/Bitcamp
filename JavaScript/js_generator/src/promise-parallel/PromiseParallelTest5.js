function plus(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 + num2

            console.log(num1 + " + " + num2 + " = ")
            resolve(res)
        }, 3000)
    })
}

function minus(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 - num2

            console.log(num1 + " - " + num2 + " = ")
            resolve(res)
        }, 2000)
    })
}

function mult(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 * num2

            console.log(num1 + " * " + num2 + " = ")
            resolve(res)
        }, 1500)
    })
}

function divide(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 / num2

            console.log(num1 + " / " + num2 + " = ")
            resolve(res)
        }, 1000)
    })
}

// 4와 비교해 훨씬 빠름
// 변수를 많이 써야 해서 불편
async function asyncProcess() {
    // Promise. 스레드나 마찬가지
    // 병렬로 우선 돌고
    const p1 = plus(100, 200)
    const p2 = minus(100, 200)
    const p3 = mult(100, 200)
    const p4 = divide(100, 200)

    // 값 세팅을 나중에 함
    const res1 = await p1
    const res2 = await p2
    const res3 = await p3
    const res4 = await p4

    // 연산이 끝나면 다같이 출력
    console.log(res1)
    console.log(res2)
    console.log(res3)
    console.log(res4)
}

asyncProcess()

const PromiseParallelTest5 = () => {
    console.log("PromiseParallelTest5 Start")

    console.log("PromiseParallelTest5 Fin")

    return (
        <div className="PromiseParallelTest5">
            <p>PromiseParallelTest5</p>
        </div>
    )
}

export default PromiseParallelTest5