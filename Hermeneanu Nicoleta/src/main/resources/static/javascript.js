var image = document.getElementById("heart");

function changeColor(image) {
    if (image.src.indexOf("/images/heart.png") > -1) {
        image.src = "/images/heart2.png";
    } else {
        image.src = "/images/heart.png";
    }
}
