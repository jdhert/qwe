let id = 6;
form.addEventListener("submit", (e) => {
    e.preventDefault();
    let formData = { "id": `${id++}`, "todo" : input.value, "done" : "false"};
    fetch("/api/todos", {
        method: `POST`,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(formData),
    });
    let a = input.value;
    input.value = "";
    let li2 = `<li>${a}</li>`;
    document.querySelector("#todos").innerHTML += li2;
});



async function view() {
    document.querySelector("#todos").innerHTML = "";
    let li = "";
    let res = await fetch("/api/todos");
    let a = await res.json();
    a.forEach((ele) => {
        li += `<li>${ele.todo}</li> <span hidden>${ele.id}</span>`;
    });
    document.querySelector("#todos").innerHTML += li;
}


view();


// document.querySelector(".todos").addEventListener('contextmenu', function(event) {
//     console.log("우클릭!");
//     event.preventDefault(); // li 엘리먼트에서의 우클릭 메뉴 비활성화
// });

// todoEl.addEventListener("contextmenu", (e) => {
//     e.preventDefault();
//     todoEl.remove();
//     updateLS();
// });

window.oncontextmenu=function() {
    return false;
}
document.querySelector(".todos").addEventListener('mousedown', function(event) {
    if (event.button === 2) {
        // event.target이 li인 경우에만 로그 출력
        if (event.target.tagName === 'LI') {
            console.log("오른쪽이 으악!");
        }
    }
});
