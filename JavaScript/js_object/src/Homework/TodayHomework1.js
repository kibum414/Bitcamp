// 아래와 같은 수열이 있다.
// 1, 1, 1, 3, 5, 9, 17, 31, 57, 105, 193, .......
// 이 수열의 20번째 값을 구할 수 있도록 프로그래밍 해보자!

const TodayHomework1 = () => {
// function TodayHomework1() {
    const NUM = 20
    let arr = []

    arr[0] = 1
    arr[1] = 1
    arr[2] = 1

    for (var i = 3; i < NUM; i++) {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
    }

    console.log(`${NUM}번째 값 : ` + arr[NUM - 1])

    return (
        <div className="TodayHomework1">
            <p>
                Today's Homework 1
            </p>
        </div>
    )
}

export default TodayHomework1