const RepeatFindTest = () => {
    let seq = [1, 2, 3, 4, 5]
    let firstFind = seq.find(findFunc)
    // 조건을 만족하는 가장 첫 번째 순서 값 찾을 때 사용

    function findFunc(value) {
        return value > 2
    }

    console.log("After find(): " + firstFind)

    let firstFindIdx = seq.findIndex(findIdxFunc)
    // 조건 만족하는 가장 첫 번째 순서 인덱스 찾을 때 사용

    function findIdxFunc(value) {
        return value > 4
    }

    console.log("After findIndex(): " + firstFindIdx)

    return (
        <div className="RepeatFindTest">
            <p>
                index-test: IndexTest
            </p>RepeatFindTest
        </div>
    )
}

export default RepeatFindTest