const RepeatEveryTest = () => {
    let seq = [1, 2, 3, 4, 5]
    let andTestSuccess = seq.every(andTestFunc)
    // Array<number>.reduce(callbackfn: (previousValue: number, currentValue))

    // boolean 값 반환
    // 이 테스트를 모든 녀석이 통과할 수 있냐
    // 모든 데이터가 조건을 만족할 때 true
    // 데이터들이 어떤 조건을 만족할 때만 통과시킬 때 사용
    // 교집합
    function andTestFunc(value) {
        return value > 3
    }

    console.log("After every(): " + andTestSuccess)

    andTestSuccess = seq.every(andTestFunc2)

    function andTestFunc2(value) {
        return value > 0
    }

    console.log("After every(): " + andTestSuccess)

    if (seq.every(andTestFunc2)) {
        console.log('이렇게 두 줄')
    }

    return (
        <div className="RepeatEveryTest">
            <p>
                repeat-test: RepeatEveryTest
            </p>
        </div>
    )
}

export default RepeatEveryTest