# Positional

  A very flexible and customizable location related information app..

  ![alt text](https://github.com/Hamza417/Positional/blob/master/poster.png?raw=false)

## Stats

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FHamza417%2FPositional&count_bg=%233FA6E6&title_bg=%23FB062F&icon=github.svg&icon_color=%23FFFFFF&title=Total+Visited&edge_flat=false)](https://hits.seeyoufarm.com)
[![Download](https://badgen.net/badge/Download/v1.0-beta/grey?icon=https://svgshare.com/i/Qk3.svg)](https://github.com/Hamza417/Positional/releases/tag/v1.0-beta)
![Status](https://badgen.net/badge/Status/beta/orange?icon)

## Features
  * Easy to use<br/>
  * Smooth, with fluid animations<br/>
  * Minimal UI<br/>
  * Parallax effect<br/>
  * Customisable with various options to choose from<br/>
  * Flexible, options for different elements can be choosen seprately or can be disabled entirely<br/>
  * Torch

## Features yet to be added

   ### Most Priority
  - [ ] GPS information panel
  - [ ] Dark Mode - Providing options for skins made this part a bit complicated
  - [ ] A separate fragment for torch
  - [ ] Swipeable interface

 ### Least priority
  - [ ] Simplifying interface by adding few indicators refering the currently visible screen
  - [ ] Set of icons to choose from

## Known Issues (so far)
  - [ ] Parallax sensor values are wrong sometimes
  - [ ] Dialer rotating back to it's original state sometimes causes resource and input lock
  - [x] ~~Updating sensor values in the background **Handler Thread** to free up the UI load~~ <br/>
      <sub>**(21 Oct, 2020)** - Sensor values cannot be updated in the background thread as the updating UI from the background causes a significant UI lag and communication delay<sub>
  
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Libraries Used
* [Material Popup Menu](https://github.com/zawadz88/MaterialPopupMenu) by **Piotr Zawadzki**
  
## License
  <a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/">Creative Commons Attribution-NonCommercial 4.0 International License</a>.
