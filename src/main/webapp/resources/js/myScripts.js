
function filterByColumn(column) {
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[column];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

    function validate() {
        if (document.f.username.value == "" && document.f.password.value == "") {
            alert("Username and password are required");
            document.f.username.focus();
            return false;
        }
        if (document.f.username.value == "") {
            alert("Username is required");
            document.f.username.focus();
            return false;
        }
        if (document.f.password.value == "") {
            alert("Password is required");
            document.f.password.focus();
            return false;
        }
    }
