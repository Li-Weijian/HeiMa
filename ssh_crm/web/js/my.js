//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下啦选放入的标签id
//参数3: 生成下拉选时,select标签的name属性值
//参数4: 需要回显时,选中哪个option
function loadSelect(typeCode,positionId,selectName,selectId) {
    //1.创建一个select对象，将name属性添加
    var $select = $("<select name="+selectName+"><select/>");
    //2.添加提示s
    $select.append($("<option value=''>---请选择---</option>"));
    //3.使用ajax获取数据
    $.post("${pageContext.request.contextPath}/baseDictAction", {dict_type_code: typeCode},
        function(data){
            //4.返回的json对象，对其进行遍历
            $.each(data,function (i,json) {
                var $option = $("<option value='"+json['dict_id']+"'>"+json['dict_item_name']+"</option>");

                //5.判断是否需要回显
                if (json["dict_id"] == selectId){
                    $option.attr("selected","selected");
                }
                //6.添加到select
                $select.append($option);
            });
        },
        "json");

    //添加到select
    $("#"+positionId).append($select);
}
