const promise = new Promise(
    function (resolve, reject) {
        setTimeout(function () {
            console.log("Hello ")
            resolve("World!!!")
        }, 2000)
    }
)

// 앞에 숫자 2 안 나옴
promise.then(function (response) {
    console.log(response)
})

// 프로미스는 자바스크립트 엔진이 관리
// 실행 시 프로미스를 스레드 화 (Promise, then 두 가지)
// 메인은 따로 돎

// 메인 안에 있을 시 두 번씩 출력되는 이유
// 자바 스크립트 엔진이 스레드화 한 것을
// 한 번 더 실행하게 됨
const PromiseTest2 = () => {
    // 메인 스레드는 실행 후 대기 (Start, Fin)
    console.log("PromiseTest2 Start")

    // 앞에 숫자 2 나옴 (두 번 출력)
    // promise.then(function (response) {
    //     console.log(response)
    // })

    console.log("PromiseTest2 Fin")

    return (
        <div className="PromiseTest2">
            <p>PromiseTest2</p>
        </div>
    )
}

export default PromiseTest2