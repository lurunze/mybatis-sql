# Mybatis SQL

![Build](https://github.com/lurunze/mybatis-sql/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/14844-mybatis-sql.svg)](https://plugins.jetbrains.com/plugin/14844-mybatis-sql)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/14844-mybatis-sql.svg)](https://plugins.jetbrains.com/plugin/14844-mybatis-sql)


<!-- Plugin description -->
Convert selected Mybatis log to an executable SQL. 
## Usage
### Method 1 (recommended):
* Select the log containing `Preparing` and `Parameters` (extra lines will be filtered).
* Right-click the mouse and select the `Copy as SQL` menu (shortcut key: `shift + alt + H`) to copy SQL.
### Method 2
* Select the log containing `Preparing` and `Parameters` (extra lines will be filtered).
* Right-click and select the `Show SQL` menu (shortcut key: `ctrl + shift + H`) to display SQL.
* Click the `COPY TO CLIPBOARD` button to copy the SQL.

## 使用
### 方法1（推荐）：
* 选择包含 `Preparing` 和 `Parameters` 的日志（多余的行会被过滤）。
* 鼠标右键，选择 `Copy as SQL` 菜单（快捷键：`shift + alt + H`）复制 SQL。
### 方法2
* 选择包含 `Preparing` 和 `Parameters` 的日志（多余的行会被过滤）。
* 鼠标右键，选择 `Show SQL` 菜单（快捷键：`ctrl + shift + H`）展示 SQL。
* 点击 `COPY TO CLIPBOARD` 按钮复制 SQL。

##Screenshots
![](https://github.com/lurunze/mybatis-sql/blob/master/images/screenshots1.png?raw=true)

![](https://github.com/lurunze/mybatis-sql/blob/master/images/screenshots2.png?raw=true)

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
