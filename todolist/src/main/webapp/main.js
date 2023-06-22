function nextButtonHandler(id, type) {

    console.log("this is button " + id);

    var requestURL = "http://localhost:8080/todolist/type?id=" + id + "&type=" + type;
    var httpRequest = new XMLHttpRequest();

    if(!httpRequest) {
        alert("XMLHTTP 인스턴스 생성 불가능");
        return false;
    }

    httpRequest.open("POST", requestURL);
    httpRequest.send();

    return 'success';
}