const AddSetTest = () => {
    let setData = new Set()

    setData.add("Cherry")
    setData.add("strawberry")
    setData.add("apple")

    console.log(setData)
    // 해당 값을 가지고 있는지 확인
    console.log("AddSetTest: " + setData.has("apple"))
    console.log("AddSetTest: " + setData.has("grape"))

    return (
        <div className="AddSetTest">
            <p>AddSetTest</p>
        </div>
    )
}

export default AddSetTest