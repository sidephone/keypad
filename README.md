# Sidephone Keypad Detector
A simple class that detects the current tile and notifies your app when the tile is removed or a new one is inserted.

## Usage
0. Copy `Keypad.kt` to your project and import it.
1. Create a Keypad object.
2. Call `keypad.listenForChanges()` to activate it.
3. Use `keypad.layout.collectAsState().value` to get dynamic notifications when a tile has been inserted or removed. `value` is one of the enum items `Keypad.Layout`.
4. Call `keypad.stopListening()` when you do not need any more notifications. This will prevent memory leaks.

See [ExampleUsage.kt](ExampleUsage.kt) for a complete example of an Activity displaying the current tile in a `Text` component.

Alternatively, you could implement a class that extends `Keypad`, and override the `onChange` method. That method will be called every time a tile is inserted or removed. In the override, you can obtain the current tile from `this.layout.value`.

Refer to the [Sidephone Calculator app](https://github.com/sidephone/calculator) for an example how to use the keypad detector in a real-world application. See the `MainActivity.kt`, `Calculator.kt` for an overview how to setup and use the detector, and `CalculatorKeypad.kt` for an example how to handle key presses.

_**NOTE:** Tile detection usually happens within a second, but due to hardware specifics, it could take several seconds sometimes._

_**NOTE 2**: Actual detection is done by the Android keyboard driver. The `Keypad` class reads it from there and exposes it to any application._

## Setup
The code is written in Kotlin, and requires `kotlinx.coroutines`. If your project is in Kotlin, you are already set. If it is in Java, you may need to include the respective dependencies.

Other thant that, there are no specific requirements. Just put the file somewhere in your project and import it.

## Tile Keycodes

Below you can find lists of the `android.view.KeyEvent` keycodes each keypad tile produces

### Compact-QWERTY
| Key  | KeyCode |
| ---- | ------- |
| Call     | _Not accessible by normal apps_ |
| Left Function     | KEYCODE_BACK |
| Center Function     | _Not accessible by normal apps_ |
| Right Function     | _Not accessible by normal apps_ |
| End Call | KEYCODE_ENDCALL |
| Q W | KEYCODE_Q |
| E R | KEYCODE_E |
| T Y | KEYCODE_T |
| U I | KEYCODE_U |
| O P | KEYCODE_O |
| A S | KEYCODE_A |
| D F | KEYCODE_D |
| G H | KEYCODE_G |
| J K | KEYCODE_J |
| L | KEYCODE_L |
| Z X | KEYCODE_Z |
| C V | KEYCODE_C |
| B N | KEYCODE_B |
| M | KEYCODE_M |
| ⌫ | KEYCODE_DEL |
| ⟠ | KEYCODE_CTRL_LEFT |
| ✱ + SYM | KEYCODE_ALT_LEFT |
| 0 SPACE | KEYCODE_SPACE |
| # ▵aA▵ | KEYCODE_SHIFT_LEFT |
| ⏎ | KEYCODE_ENTER |

### T9 "Classic" with D-pad
| Key  | KeyCode |
| ---- | ------- |
| Call     | _Not accessible by normal apps_ |
| End Call | KEYCODE_ENDCALL |
| Left Function Key | _Not accessible by normal apps_ |
| Right Function Key | KEYCODE_DEL |
| D-pad Up | KEYCODE_DPAD_UP |
| D-pad Down | KEYCODE_DPAD_DOWN |
| D-pad Left | KEYCODE_DPAD_LEFT |
| D-pad Right | KEYCODE_DPAD_RIGHT |
| D-pad Center | KEYCODE_ENTER |
| 0-9 | KEYCODE_0 - KEYCODE_9 |
| ✱ | KEYCODE_STAR |
| # | KEYCODE_POUND |


### T9 "Classic" without D-pad
| Key  | KeyCode |
| ---- | ------- |
| Left Function Key | _Not accessible by normal apps_ |
| Center Function Key | _Not accessible by normal apps_ |
| Right Function Key | KEYCODE_ENDCALL |
| 0-9 | KEYCODE_0 - KEYCODE_9 |
| ✱ | KEYCODE_STAR |
| # | KEYCODE_POUND |

### Sundial
| Key  | KeyCode |
| ---- | ------- |
| Upper-Left Corner | KEYCODE_DPAD_LEFT |
| Upper-Right Corner | KEYCODE_DPAD_RIGHT |
| Lower-Left Corner | KEYCODE_TAB |
| Lower-Right Corner | KEYCODE_ENTER |
| UP | KEYCODE_DPAD_UP |
| DOWN | KEYCODE_DPAD_DOWN |
| LEFT | KEYCODE_MEDIA_PREVIOUS |
| RIGHT | KEYCODE_MEDIA_NEXT |
| CENTER | KEYCODE_MEDIA_PLAY_PAUSE |

### Gamepad
| Key  | KeyCode |
| ---- | ------- |
| Up | KEYCODE_DPAD_UP |
| Down | KEYCODE_DPAD_DOWN |
| Left | KEYCODE_DPAD_LEFT |
| Right | KEYCODE_DPAD_RIGHT |
| Bottom-Left Function Key | KEYCODE_BUTTON_START |
| Top-Right Function Key | KEYCODE_BUTTON_SELECT |
| X | KEYCODE_BUTTON_X |
| Y | KEYCODE_BUTTON_Y |
| A | KEYCODE_BUTTON_A |
| B | KEYCODE_BUTTON_B |

_**NOTE:** KEYCODE_BUTTON_X, KEYCODE_BUTTON_Y, KEYCODE_BUTTON_A, and KEYCODE_BUTTON_B are the keycodes for the gamepad buttons, while KEYCODE_X, KEYCODE_Y, KEYCODE_A, and KEYCODE_B are the keycodes for the corresponding keyboard keys. They are not the same and should not be confused with each other._
