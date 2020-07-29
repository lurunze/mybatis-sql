# Mybatis SQL

![Build](https://github.com/lurunze/mybatis-sql/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)


<!-- Plugin description -->
Convert selected Mybatis log to an executable SQL. 
## Usage
* Select log containing `Preparing` and `Parameters`.
* click the right mouse then choose `Mybatis SQL` menu or just use shortcut keys `ctrl + shift + H`.

Then the generated executable SQL will pop up as a notification in the lower right corner.
At the same time, the SQL will also be recorded in  `Event Log` menu in the lower right corner.

## 使用
* 选择包含 `Preparing` 和 `Parameters` 的日志。
* 点击鼠标右键，然后选则 `Mybatis SQL` 菜单，或者使用快捷键 `ctrl + shift + H`。

生成的可执行 SQL 会在右下角以通知的形式弹出。同时 SQL 还会被记录在右下角的 `Event Log` 菜单。

<b>
<a href="https://github.com/lurunze/mybatis-sql">GitHub</a><br>
</b>
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Mybatis SQL"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/lurunze/mybatis-sql/releases/latest) and install it manually using
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
