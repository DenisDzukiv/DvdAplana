<script language="JavaScript 1.1" type="text/javascript">
    function getXmlHttp() {
        if (typeof XMLHttpRequest === 'undefined') {
            XMLHttpRequest = function () {
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP.6.0");
                }
                catch (e) {
                }
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP.3.0");
                }
                catch (e) {
                }
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e) {
                }
                try {
                    return new ActiveXObject("Microsoft.XMLHTTP");
                }
                catch (e) {
                }
                throw new Error("This browser does not support XMLHttpRequest.");
            };
        }
        return new XMLHttpRequest();
    }

    function TakeDisk(diskId) {
        var
                l_xmlhttp = getXmlHttp(),
                l_url = "takeDisk?diskId=" + diskId;

        l_xmlhttp.open("GET", l_url, true);
        l_xmlhttp.onreadystatechange = function () {
            try {
                if (l_xmlhttp.readyState == 4) {
                    if (l_xmlhttp.status == 200) {
                        alert("Disk Taken!");
                        window.location.reload();
                    }
                }
            } catch (e) {
                //alert("Произошла непредвиденная ошибка при работе javascript. Пожалуйста, обновите страницу. Ошибка: " + e);
                alert("Error: " + e);
            }
        };
        l_xmlhttp.send();
    }
</script>