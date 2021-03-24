#QUESTION NOTE (210127)

**Q** isOK 의 용도가 정확히 무엇인지 잘 모르겠습니다.
```java
// 클라이언트 리스트를 차례대로 돌며
for (ClientHandler ch : ThreadChatServer.chv) {
    // 서버로부터 받은 이름과 받는 사람으로 입력된 값이 일치하고
    // q를 입력한 게 아니면 ???
    if (ch.name.equals(recipient) && ch.isOK == true) {
        // 송신 채널을 통해 해당 클라이언트에게 보낸 사람과 메시지 내용을 출력
        ch.out.writeUTF(this.name + " : " + msg2Send);
        // for 문 탈출
        break;
    }
}
```