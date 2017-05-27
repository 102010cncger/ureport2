/**
 * Created by Jacky.Gao on 2017-02-07.
 */
import {alert} from '../MsgBox.js';

export default class MethodSelectDialog{
    constructor(){
        this.dialog=$(`<div class="modal fade" role="dialog" aria-hidden="true" style="z-index: 10000">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title">
                            SpringBean数据集配置
                        </h4>
                    </div>
                    <div class="modal-body"></div>
                    <div class="modal-footer"></div>
                </div>
            </div>
        </div>`);
        const body=this.dialog.find('.modal-body'),footer=this.dialog.find(".modal-footer");
        this.initBody(body,footer);
    }
    initBody(body,footer){
        const table=$(`<table class="table table-bordered">
            <thead><tr style="background: #f4f4f4"><td>方法名</td><td>选择</td></tr></thead>
        </table>`);
        this.tbody=$(`<tbody></tbody>`);
        table.append(this.tbody);
        body.append(table);
    }
    show(onSelect,beanId){
        this.dialog.modal('show');
        this.tbody.empty();
        const _this=this;
        $.ajax({
            url:window._server+"/datasource/loadMethods",
            data:{beanId},
            success:function(result){
                for(let method of result){
                    const tr=$(`<tr><td>${method}</td></tr>`);
                    const selectTD=$(`<td></td>`);
                    tr.append(selectTD);
                    const selector=$(`<a href="###"><i class="glyphicon glyphicon-hand-up" style="font-size: 13pt"></i></a>`);
                    selector.click(function(){
                        onSelect.call(this,method);
                        _this.dialog.modal('hide');
                    });
                    selectTD.append(selector);
                    _this.tbody.append(tr);
                }
            },
            error:function(){
                alert("加载Bean["+beanId+"]的可用方法失败！");
            }
        });
    }
}