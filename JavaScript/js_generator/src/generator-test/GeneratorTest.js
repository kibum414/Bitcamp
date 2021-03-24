function* getName() {
    console.log("Generator")
    // 함수 실행 중 멈추고 위치 기억함
    // 컨텍스트 스위칭과 비슷
    // 제어권 활용
    yield "David"

    console.log("Generator")
    yield "Tom"
    
    console.log("Generator")
    yield "Kevin"
    
    console.log("Generator End")
}

function* getMajor() {
    console.log("Generator Major")
    const major = yield "Which subject do you like ?"

    console.log("Generator Major")
    const name = yield "What's your name ?"

    return `${name} ${major}`
}

const GeneratorTest = () => {
    let nameIter = getName()

    console.log(nameIter.next())
    console.log(nameIter.next())
    console.log(nameIter.next())
    console.log(nameIter.next())

    let majorIter = getMajor()


    console.log(majorIter.next())
    console.log(majorIter.next("Radar Signal Processing"))
    console.log(majorIter.next("John"))

    // yield를 통해서 중간에 멈춰둘 수 있다.
    
    return (
        <div className="GeneratorTest">
            <p>GeneratorTest</p>
        </div>
    )
}

export default GeneratorTest