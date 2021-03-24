const DefaultParam = () => {
    // second = 3 : default parameter
    // 값이 없으면 3이 들어감
    const defParam = (first, second = 3) => {
        return first + second
    }

    let sum = defParam(1, 2)

    console.log(sum)

    sum = defParam(1)

    console.log(sum)

    return (
        <div className="DefaultParam">
            <p>DefaultParam</p>
        </div>
    )
}

export default DefaultParam