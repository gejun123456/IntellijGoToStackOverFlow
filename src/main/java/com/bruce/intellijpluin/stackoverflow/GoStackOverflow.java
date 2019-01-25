package com.bruce.intellijpluin.stackoverflow;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;

/**
 * @Author bruce.ge
 * @Date 2017/2/26
 * @Description
 */
public class GoStackOverflow extends AnAction {

    public GoStackOverflow(){
        super(null,null, new ImageIcon(GoStackOverflow.class.getClassLoader().getResource("icon/stackoverflow.ico")));
    }
    @Override
    public void actionPerformed(AnActionEvent e) {
        String desc = this.getTemplatePresentation().getDescription();
        String baseUrl;
        if ("google".equalsIgnoreCase(desc)){
            baseUrl = "https://www.google.com/?#newwindow=1&q=site:stackoverflow.com ";
        }else{
            baseUrl = "https://www.baidu.com/s?si=stackoverflow.com&ct=2097152&wd=";
        }
        CaretModel caretModel = e.getData(LangDataKeys.EDITOR).getCaretModel();
        Caret currentCaret =
                caretModel.getCurrentCaret();
        String selectedText = currentCaret.getSelectedText();
        if (StringUtils.isNotBlank(selectedText)) {
            BrowserUtil.browse(baseUrl + selectedText + "&*");
        } else {
            BrowserUtil.browse(baseUrl + "&*");
        }
    }
}
