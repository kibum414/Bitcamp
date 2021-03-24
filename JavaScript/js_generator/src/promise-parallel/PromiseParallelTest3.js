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

// race : 경주 => 먼저 들어온 놈이 임자
// 대기 시간 짧은 divide 가 선점하여 결과를 출력하고
// 나머지는 출력 X
// 경우에 따라 어떤 게 가장 좋을지 알 수 없을 때
// 제일 빠른 것을 선택하겠다.
Promise.race([
    plus(100, 200),
    minus(100, 200),
    mult(100, 200),
    divide(100, 200)
]).then(response => console.log(response))

const PromiseParallelTest3 = () => {
    console.log("PromiseParallelTest3 Start")

    console.log("PromiseParallelTest3 Fin")

    return (
        <div className="PromiseParallelTest3">
            <p>PromiseParallelTest3</p>
        </div>
    )
}

export default PromiseParallelTest3