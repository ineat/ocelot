
var ingredientInput=document.getElementById("new-ingredient");
var addButton=document.getElementById("add");
var submitButton=document.getElementById("submit");
var ingredientsList=document.getElementById("ingredients");
var closeWinButton=document.getElementById("closeWin");
var closeLoseButton=document.getElementById("closeLose");

var createNewIngredientElement=function(ingredientId, ingredientName){
    var listItem=document.createElement("li");
    var label=document.createElement("label");//label
    var deleteButton=document.createElement("button");//delete button

    label.innerText=ingredientName;
    deleteButton.id=ingredientId;
    deleteButton.innerText="X";
    deleteButton.className="delete";
    listItem.appendChild(label);
    listItem.appendChild(deleteButton);
    return listItem;
}

var addIngredient=function(){
    if(ingredientInput.value != "") {
        var listItem = createNewIngredientElement(ingredientInput.value, ingredientInput.selectedOptions[0].innerText);
        sessionStorage.setItem(ingredientInput.value, ingredientInput.value);
        ingredientsList.appendChild(listItem);
        bindEvents(listItem);
        ingredientInput.value = "";
    }
}

var deleteIngredient=function(){
    var listItem=this.parentNode;
    var ul=listItem.parentNode;
    ul.removeChild(listItem);
    sessionStorage.removeItem(this.id);
}

var submitRequest=function() {
    var evaluationUrl = document.getElementById("evaluationUrl").value;
    var request = new XMLHttpRequest();
    request.open('POST', evaluationUrl, true);
    request.withCredentials = true;
    request.setRequestHeader("Content-Type", "application/json");
    request.setRequestHeader("Access-Control-Allow-Origin", "*");
    var ingredients = Object.keys(sessionStorage);
    var params = {
        ingredientsIds: ingredients
    }
    request.onload = function () {
        if(this.response == 'true') {
            document.getElementById("win").style.display = "block";
        } else {
            document.getElementById("lose").style.display = "block";
        }
    }
    request.send(JSON.stringify(params));
}

var closePopup=function() {
    var modalLose = document.getElementById("lose");
    var modalWin = document.getElementById("win");
    modalWin.style.display = "none";
    modalLose.style.display = "none";
}

addButton.onclick=addIngredient;
addButton.addEventListener("click",addIngredient);

submitButton.addEventListener("click",submitRequest);

closeLoseButton.addEventListener("click",closePopup);
closeWinButton.addEventListener("click",closePopup);

var bindEvents=function(ingredients){
    var deleteButton=ingredients.querySelector("button.delete");
    deleteButton.onclick=deleteIngredient;
}

sessionStorage.clear();

for (var i=0; i<ingredientsList.children.length;i++){
    bindEvents(ingredientsList.children[i]);
}