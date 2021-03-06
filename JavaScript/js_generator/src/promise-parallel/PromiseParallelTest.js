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

// plus부터 시작해 각각 대기 타임 가지며 실행됨
// 3초 뒤 실행
plus(100, 200).then(function (response) {
    console.log("plus: " + response)
    return minus(100, 200)
// plus 동작 후 2초 뒤 실행
}).then(function (response) {
    console.log("minus: " + response)
    return mult(100, 200)
// minus 동작 후 1.5초 뒤 실행
}).then(function (response) {
    console.log("mult: " + response)
    return divide(100, 200)
// mult 동작 후 1초 뒤 실행
}).then(function (response) {
    console.log("divide: " + response)
})

const PromiseParallelTest = () => {
    console.log("PromiseParallelTest Start")

    console.log("PromiseParallelTest Fin")

    return (
        <div className="PromiseParallelTest">
            <p>PromiseParallelTest</p>
        </div>
    )
}

export default PromiseParallelTest