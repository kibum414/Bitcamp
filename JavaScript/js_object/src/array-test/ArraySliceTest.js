const ArraySliceTest = () => {
    let arr = [1, 2, 3, 4, 5, 6, 7]

    console.log("Before Slice = " + arr)

    // splice는 동작 후 원본이 바뀌는데
    // slice는 동작 후에도 원본이 바뀌지 않는다.
    let slicedArr = arr.slice(3)

    console.log("slicedArr = " + slicedArr)
    console.log("After Slice = " + arr)
    
    arr = [1, 2, 3, 4, 5, 6, 7]

    console.log("Before Slice = " + arr)

    slicedArr = arr.slice(1)

    console.log("slicedArr = " + slicedArr)
    console.log("After Slice = " + arr)

    return (
        <div className="ArraySliceTest">
            <p>
                Array Slice Test
            </p>
        </div>
    )
}

export default ArraySliceTest