const promise = new Promise(
    function (resolve, reject) {
        setTimeout(function () {
            console.log("Hello ")
            resolve("World!")
        }, 2000)
    }
)

promise.then(function (response) {
    console.log(response)

    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            console.log("JavaScript Programming")
            resolve("~~~!!!")
        }, 1000)
    })
}).then(response =>
    // response 받아주지 않아서 ~~~!!! 출력 안 됨
    // JavaScript Programming 출력 후 바로 Success 출력
    console.log("Success")
).catch(function (error) {
    console.log(error)
}).finally(() => {
    console.log("PromiseTest7: 나는 무조건 실행된다!!!")
})

const PromiseTest7 = () => {
    console.log("PromiseTest7 Start")

    console.log("PromiseTest7 Fin")

    return (
        <div className="PromiseTest7">
            <p>PromiseTest7</p>
        </div>
    )
}

export default PromiseTest7