const ArrowFunctionTest3 = () => {
    let addTwoParam = function (a, b) { return a + b }
    console.log("ArrowFunctionTest3: " + addTwoParam(3, 7))

    let addTwoParamArrow = (a, b) => { return a + b }
    console.log("ArrowFunctionTest3: " + addTwoParamArrow(3, 7))

    return (
        <div className="ArrowFunctionTest3">
            <p>
                ArrowFunctionTest3
            </p>
        </div>
    )
}

export default ArrowFunctionTest3