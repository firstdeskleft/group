"use strict";

// ********** Input Tour Date **********

(function getCurrentDate() {
  let now = new Date();
  let day = ("0" + now.getDate()).slice(-2);
  let month = ("0" + (now.getMonth() + 1)).slice(-2);
  let today = now.getFullYear() + "-" + (month) + "-" + (day);
  document.getElementById('createTourDate').value = today;
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




