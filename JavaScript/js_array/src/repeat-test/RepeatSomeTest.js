const RepeatSomeTest = () => {
    let seq = [1, 2, 3, 4, 5]
    let orTestSuccess = seq.some(orTestFunc)

    // 데이터 중 하나라도 조건을 만족하면 true
    // 하나라도 불량이 아니면 대박일 때
    // 어떤 경우에 한 값만 들어오면 될 때 사용
    // 합집합
    function orTestFunc(value) {
        return value > 3
    }

    console.log("After some(): " + orTestSuccess)

    return (
        <div className="RepeatSomeTest">
            <p>
                repeat-test: RepeatSomeTest
            </p>
        </div>
    )
}

export default RepeatSomeTest