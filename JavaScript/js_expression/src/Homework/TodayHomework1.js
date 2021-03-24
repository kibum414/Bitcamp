const TodayHomework1 = () => {
    const TEAMNUMBER = 2

    let nameA = ["최현정", "오진욱", "류슬기", "장해솔", "조진형",
        "이정현", "고동영", "박재민", "한다은"]
    let nameB = ["최임식", "탁성진", "하진주", "이범진",
        "이승윤", "박기범", "박소현", "노찬욱"]
    
    let teamA = []
    let teamB = []

    function RandomTeam(name) {
        let len = name.length
        let team = []
        let randNum

        for (var i = 0; i < len; ) {
            randNum = Math.floor(Math.random() * len)

            if (!team.includes(name[randNum])) {
                team.push(name[randNum])
                i++
            }
        }

        return team
    }

    teamA = new RandomTeam(nameA)
    teamB = new RandomTeam(nameB)

    console.log("A조: " + teamA.toString())
    console.log("B조: " + teamB.toString())

    console.log("\nA조")
    divTeam(teamA)
    console.log("\nB조")
    divTeam(teamB)

    function divTeam(team) {
        let len = team.length
        let teamNum = TEAMNUMBER
        let str = ""
        let cnt = 1
        let randValue = 0

        let quot = parseInt(len / teamNum)
        let remain = len % teamNum
        let boolRemain = (remain > 0)

        for (var i = 0; i < len; i++) {
            str += team[i] + " "

            if (boolRemain) {
                randValue = Math.floor(Math.random() * 2)

                if (teamNum === remain) randValue = 1
                if (randValue === 1) remain--
                if (remain < 0) randValue = 0

                boolRemain = false
            }

            if (cnt === (quot + randValue)) {
                console.log(str)

                str = ""
                boolRemain = true
                cnt = 0
                teamNum--
            }

            cnt++
        }
    }

    return (
        <div className="TodayHomework">
            <p>
                Today's Homework 1
            </p>
        </div>
    )
}

export default TodayHomework1