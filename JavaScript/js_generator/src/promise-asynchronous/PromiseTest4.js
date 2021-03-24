const promise = new Promise(
    function (resolve, reject) {
        setTimeout(function () {
            console.log("Hello ")
            reject("Error!")
        }, 2000)
    }
)

// finally는 반드시 실행됨

// 자바스크립트 엔진 사용 시
// setTimeout 사용

// Promise 사용 시
// 제어권을 자바스크립트 엔진이 가져감
// resolv -> then (resolv 안 해도 then으로 넘어감)
// reject -> catch
// finally -> 언제나 실행됨
promise.then(function (response) {
    console.log(response)
}).catch(function (error) {
    console.log(error)
}).finally(() => {
    console.log("나는 무조건 실행된다!!!")
})

const PromiseTest4 = () => {
    console.log("PromiseTest4 Start")

    console.log("PromiseTest4 Fin")

    return (
        <div className="PromiseTest4">
            <p>PromiseTest4</p>
        </div>
    )
}

export default PromiseTest4