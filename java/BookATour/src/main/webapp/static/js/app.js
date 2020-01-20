"use strict";

// ********** Input Tour Date **********

(function getCurrentDateAtCreate() {
  let now = new Date();
  let day = ("0" + now.getDate()).slice(-2);
  let month = ("0" + (now.getMonth() + 1)).slice(-2);
  let today = now.getFullYear() + "-" + (month) + "-" + (day);
  document.getElementById("createTourDate").value = today;
}());



// ===================== CONFIRMATIONS ALERTS ============================


// ********* Booking Confirmation (Customer Role) **********

function confirmBooking() {
  return confirm("Are you sure you want to book this Tour?");

};

// ******** Tour Delete Confirm (Guide Role) **********

function tourDeleteConfirm() {
  return confirm("Are you sure you want to delete this Tour?");
};


// ********* Booking Cancel Confirmation (Customer Role) **********

function tourCancelConfirm() {
  return confirm("Are you sure you want to cancel this Booking?");
};


//==================== Tours Filter ====================//

function filterTours(){
  const filter = document.querySelector('#searchTour').value.toUpperCase();
  const trs = document.querySelectorAll('#tourTable tr:not(.data-tourInfo)');
  trs.forEach(tr => tr.style.display = [...tr.children].find(td => td.textContent.toUpperCase().includes(filter)) ? '' : 'none');
 
};


//==================== Tours Cost Filter ====================//

function filterToursCost(){
  // const filterCost = document.querySelector('#searchTourCost').value.toUpperCase();
  const filterCost = parseFloat($("#searchTourCost").val());
  const trs = document.querySelectorAll('#tourTable tr:not(.data-tourInfo)');
  trs.forEach(tr => tr.style.display = [...tr.children].find(td => td.innerHTML.includes(filterCost)) ? '' : 'none');
}


//==================== Tours Cost Filter ====================//

function performReset() {
  document.getElementById("searchTour").value = "";
  document.getElementById("searchTourCost").value = "";
  filterTours(event, 0);
}


