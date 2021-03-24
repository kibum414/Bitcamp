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

// 시간 초가 짧은 것부터 출력
// 순서대로 X (병렬 실행)
// 배열 형식으로 출력됨
Promise.all([
    plus(100, 200),
    minus(100, 200),
    mult(100, 200),
    divide(100, 200)
]).then(response => console.log(response))

const PromiseParallelTest2 = () => {
    console.log("PromiseParallelTest2 Start")

    console.log("PromiseParallelTest2 Fin")

    return (
        <div className="PromiseParallelTest2">
            <p>PromiseParallelTest2</p>
        </div>
    )
}

export default PromiseParallelTest2