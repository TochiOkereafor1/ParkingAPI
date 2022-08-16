const carURL = "http://localhost:8080/car";


function redirect() {

    window.location = "http://127.0.0.1:5500/createCar.html";
}



//create
const createCar = () => {
    let tCollum1 = document.querySelector("#car_text_box_1").value
    let tCollum2 = document.querySelector("#car_text_box_2").value
    let tCollum3 = document.querySelector("#car_text_box_3").value
    const info = {
        "carMake": tCollum1,
        "carModel": tCollum2,
        "carRegNum": tCollum3
    }

    fetch("http://localhost:8080/car/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(info),

    })
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.err(err))
}

//Update
const updateCar = () => {
    console.log("xyz");
    

    var carId = sessionStorage.getItem("carID"); 
    console.log(carId);
    let tCollum1 = document.querySelector("#col--1").value
    let tCollum2 = document.querySelector("#col--2").value
    let tCollum3 = document.querySelector("#col--3").value
    const updateInfo = {
        "carMake": tCollum1,
        "carModel": tCollum2,
        "carRegNum": tCollum3
    }

    fetch(`http://localhost:8080/car/updateCar/${carId}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(updateInfo),

    })
        .then(res => res.json())
        .then(data => console.log(` Update successful ${data}`))
        .catch(err => console.err(err`Update Failed`));

        redirect()

            

        
};


const createCar2 = () => {
    let tCollum1 = document.querySelector("#car_text_box_1").value
    let tCollum2 = document.querySelector("#car_text_box_2").value
    let tCollum3 = document.querySelector("#car_text_box_3").value
    const info = {
        "carMake": tCollum1,
        "carModel": tCollum2,
        "carRegNum": tCollum3
    }

    fetch("http://localhost:8080/car/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(info),

    })
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.err(err))
}

const deleteCar = (carID) => {
    console.log("carID");
    fetch(`http://localhost:8080/car/deleteCar/${carID}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(res => res.json())
        .then(res => console.log(res))
        .catch(err => console.err(err `Delete Failed`));

        // write function to refresh page after delete
};

function redirectToUpdate(carID) {

    sessionStorage.setItem("carID", carID); 
    window.location = "http://127.0.0.1:5500/cars.html";
}








