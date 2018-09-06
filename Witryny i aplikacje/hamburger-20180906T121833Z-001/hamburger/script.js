const burger = document.querySelector(".burger");
const burger2 = document.querySelector(".burger2");

burger.addEventListener("click", () => {
    burger.classList.toggle("active");
});
burger2.addEventListener("click", () => {
    burger2.classList.toggle("active");
});
