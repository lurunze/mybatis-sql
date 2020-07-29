package com.github.lurunze.mybatis.sql.action;

import com.github.lurunze.mybatis.sql.util.ParsingSqlUtil;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.ui.MessageType;
import org.apache.commons.lang.StringUtils;

/**
 * @author lurunze
 */
public class SelectLogAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {

    Editor editor = e.getData(PlatformDataKeys.EDITOR);
    SelectionModel selectionModel = editor.getSelectionModel();
    String selectedText = selectionModel.getSelectedText();
    if (StringUtils.isBlank(selectedText)) {
      System.out.println("please select text");
      return;
    }
    String sql = ParsingSqlUtil.parsingSql(selectedText);

    NotificationGroup notificationGroup = new NotificationGroup("mybatisLogFree", NotificationDisplayType.STICKY_BALLOON, true);
    Notification notification = notificationGroup.createNotification(sql, MessageType.INFO);
    Notifications.Bus.notify(notification);
  }
}
