package com.bruce.intellijpluin.stackoverflow;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;

/**
 * @Author bruce.ge
 * @Date 2017/2/26
 * @Description
 */
public class GoStackOverflow extends AnAction {

    public GoStackOverflow(){
        super(null,null, new ImageIcon(GoStackOverflow.class.getClassLoader().getResource("icon/stackoverflow.png")));
    }
    @Override
    public void actionPerformed(AnActionEvent e) {
        String googleSite = "https://www.google.com/";
        CaretModel caretModel = e.getData(LangDataKeys.EDITOR).getCaretModel();
        Caret currentCaret =
                caretModel.getCurrentCaret();
        String selectedText = currentCaret.getSelectedText();
        if (StringUtils.isNotBlank(selectedText)) {
            BrowserUtil.browse(googleSite + "?q=site:stackoverflow.com " + selectedText + "&*");
        } else {
            BrowserUtil.browse(googleSite + "?q=site:stackoverflow.com " + "&*");
        }
    }
}
