const MapDeleteTest = () => {
    let mapData = new Map(
        [
            ["apple", "red"], ["grape", "purple"]
        ]
    )

    console.log(mapData)

    // 해당 데이터만 삭제
    mapData.delete("apple")

    console.log(mapData)

    // 전부 삭제
    mapData.clear()

    console.log(mapData)

    return (
        <div className="MapDeleteTest">
            <p>MapDeleteTest</p>
        </div>
    )
}

export default MapDeleteTest