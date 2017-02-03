(function($) {
    "use strict";

    $(document).ready(function() {
        // fetching all the city from city table
        $.get(_context +'/public/getFacility', {
        }, function(responseJson) {
        	var facilityList = responseJson.facilityList;
            //alert(" Calling the Alert functionality");
            var $select = $('#facilityDropDown');
            $select.find('option').remove();
            $.each(facilityList, function(key, value) {
                $('<option>').val(value.facilityName).text(value.facilityName).appendTo($select);
            });
        });

        //City Chnage Event for location value changes.
        $('#city').change(function(event) {
            var vl = $("#city option:selected").text();
            //alert('Calling the Location ');
            var $city = $("select#city").val();
            $.get('query_location.jsp', {
                type: 'new_location',
                cityname: $city
            }, function(responseJson) {
                var $select = $('#location');
                $select.find('option').remove();
                $('<option>').val("").text("--Choose Location--").appendTo($select);
                $.each(responseJson, function(key, value) {
                    // alert('REturn  key '+key+" value "+value);
                    $('<option>').val(value).text(value).appendTo($select);
                });
            });
        });

        // Our Partners Carousel
        $('#our_partners').carousel({
            interval: 4000
        });

        $('#our_partners.carousel .item').each(function() {
            var next = $(this).next();

            if (!next.length) {
                next = $(this).siblings(':first');
            }

            next.children(':first-child').clone().appendTo($(this));

            for (var i = 0; i < 4; i++) {
                next = next.next();

                if (!next.length) {
                    next = $(this).siblings(':first');
                }

                next.children(':first-child').clone().appendTo($(this));
            }
        });
    });

})(jQuery);
