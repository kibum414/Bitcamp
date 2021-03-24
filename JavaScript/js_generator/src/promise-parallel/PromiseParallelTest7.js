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

// 6보다 더 편해짐
async function asyncProcess() {
    // 배열 형식으로 출력
    const res = await Promise.all(
    // 가장 빠른 divide가 출력
    // const res = await Promise.race(
        [
            plus(100, 200),
            minus(100, 200),
            mult(100, 200),
            divide(100, 200)
        ]
    )

    console.log(res)
}

asyncProcess()

const PromiseParallelTest7 = () => {
    console.log("PromiseParallelTest7 Start")

    console.log("PromiseParallelTest7 Fin")

    return (
        <div className="PromiseParallelTest7">
            <p>PromiseParallelTest7</p>
        </div>
    )
}

export default PromiseParallelTest7