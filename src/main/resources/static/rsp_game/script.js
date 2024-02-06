
document.querySelector("#form").addEventListener("click",async event => {
   event.preventDefault();
   document.querySelector("#you").firstElementChild.src = event.target.src;
   let a, b;
   switch (document.querySelector("#you").firstElementChild.src) {
      case "http://localhost:8080/rsp_game/rock.png":
         a = "rock";
         break;
      case "http://localhost:8080/rsp_game/scissors.png":
         a = "scissors";
         break;
      case "http://localhost:8080/rsp_game/paper.png":
         a = "paper";
         break;
   }
   switch (Math.floor(Math.random() * 3 + 1)) {
      case 1:
         document.querySelector("#computer").firstElementChild.src = "/rsp_game/rock.png";
         b = "rock";
         break;
      case 2:
         document.querySelector("#computer").firstElementChild.src = "/rsp_game/scissors.png";
         b = "scissors";
         break;
      case 3:
         document.querySelector("#computer").firstElementChild.src = "/rsp_game/paper.png";
         b = "paper";
         break;
   }
   switch (a) {
      case "rock":
         if (b === "scissors") {
            document.querySelector("#result").firstElementChild.className = "winner";
            document.querySelector("#result").lastElementChild.className = "";
            let num = await fetch(`/rsp_cookie/a`, {
               method: `POST`,
            });
            let num1 = await num.json();
            document.querySelector("ul").firstElementChild.innerHTML = `Win count : ${num1}`;
         } else if (b === "paper") {
            document.querySelector("#result").firstElementChild.className = "";
            document.querySelector("#result").lastElementChild.className = "winner";
            let num = await fetch(`/rsp_cookie/b`, {
               method: `POST`,
            });
            let num1 =  await num.json();
            document.querySelector("ul").firstElementChild.nextElementSibling.innerHTML = `Lose count : ${num1}`;
         } else {
            document.querySelector("#result").firstElementChild.className = "";
            document.querySelector("#result").lastElementChild.className = "";
            let num = await fetch(`/rsp_cookie/c`, {
               method: `POST`,
            });
            let num1 = await num.json();
            document.querySelector("ul").lastElementChild.innerHTML = `Draw count : ${num1}`;
         }
         break;
      case "scissors":
         if (b === "paper") {
            document.querySelector("#result").firstElementChild.className = "winner";
            document.querySelector("#result").lastElementChild.className = "";
            let num = await fetch(`/rsp_cookie/a`, {
               method: `POST`,
            });
            let num1 = await num.json();
            document.querySelector("ul").firstElementChild.innerHTML = `Win count : ${num1}`;
         } else if (b === "rock") {
            document.querySelector("#result").firstElementChild.className = "";
            document.querySelector("#result").lastElementChild.className = "winner";
            let num = await fetch(`/rsp_cookie/b`, {
               method: `POST`,
            });
            let num1 = await num.json()
            document.querySelector("ul").firstElementChild.nextElementSibling.innerHTML = `Lose count : ${num1}`;
         } else {
            document.querySelector("#result").firstElementChild.className = "";
            document.querySelector("#result").lastElementChild.className = "";
            let num = await fetch(`/rsp_cookie/c`, {
               method: `POST`,
            });
            let num1 = await num.json()
            document.querySelector("ul").lastElementChild.innerHTML = `Draw count : ${num1}`;
         }
         break;
      case "paper":
         if (b === "rock") {
            document.querySelector("#result").firstElementChild.className = "winner";
            document.querySelector("#result").lastElementChild.className = "";
            let num = await fetch(`/rsp_cookie/a`, {
               method: `POST`,
            });
            let num1 = await num.json();
            document.querySelector("ul").firstElementChild.innerHTML = `Win count : ${num1}`;
         } else if (b === "scissors") {
            document.querySelector("#result").firstElementChild.className = "";
            document.querySelector("#result").lastElementChild.className = "winner";
            let num = await fetch(`/rsp_cookie/b`, {
               method: `POST`,
            });
            let num1 = await num.json()
            document.querySelector("ul").firstElementChild.nextElementSibling.innerHTML = `Lose count : ${num1}`;
         } else {
            document.querySelector("#result").firstElementChild.className = "";
            document.querySelector("#result").lastElementChild.className = "";
            let num = await fetch(`/rsp_cookie/c`, {
               method: `POST`,
            });
            let num1 = await num.json()
            document.querySelector("ul").lastElementChild.innerHTML = `Draw count : ${num1}`;
         }
         break;
   }
});