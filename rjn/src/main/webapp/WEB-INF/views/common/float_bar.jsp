<style media="screen">
    #float_bar {
        position: fixed;
        top: 400px;
        right: -64px;
        transform: rotate(-90deg);
        -webkit-transform: rotate(-90deg);
        -moz-transform: rotate(-90deg);
        -ms-transform: rotate(-90deg);
        -o-transform: rotate(-90deg);
        filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=3);
        z-index: 9999;
    }
    #float_bar .btn {
        border-radius: 10px 10px 0 0;
    }
</style>
<div id="float_bar" class="hidden-xs">
    <a class="btn btn-default btn-md" href="${rc.getContextPath()}/list-your-shop">List you Shop</a>
</div>
