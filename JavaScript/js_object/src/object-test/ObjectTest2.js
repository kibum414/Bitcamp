function ObjectTest2() {
    let obj = {
        _name: "test",

        get name() {
            console.log("I'm Getter")
            return this._name
        },
        set name(value) {
            console.log("I'm Setter")
            this._name = value
        }
    }

    // get name 호출
    console.log("ObjectTest2: " + obj.name)
    // 호출 없이 test 출력
    console.log("ObjectTest2: " + obj._name)

    // set name 호출 (value 로 gogosing)
    obj.name = "gogosing"
    // get name 호출
    console.log(obj.name)

    return (
        <div className="ObjectTest2">
            <p>
                Object Test 2
            </p>
        </div>
    )
}

export default ObjectTest2