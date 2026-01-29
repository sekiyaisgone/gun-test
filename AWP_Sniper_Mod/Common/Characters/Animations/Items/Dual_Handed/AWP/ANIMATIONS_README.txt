AWP Animation Assets - Required Files
=======================================

Place the following .blockyanim files in this directory:

1. AWP_Idle.blockyanim
   - Subtle breathing sway while holding the weapon
   - Duration: 4.0 seconds (looping)
   - Bone movement: Slight up/down sway on the awp root bone

2. AWP_Shoot.blockyanim
   - Recoil animation triggered on fire
   - Duration: 0.8 seconds
   - Includes: trigger pull, weapon recoil kick, bolt auto-cycle
   - Bones involved: awp (recoil), trigger (pull), bolt (cycle)

3. AWP_Shoot_FPS.blockyanim
   - First-person version of the shoot animation
   - Duration: 0.8 seconds
   - More pronounced recoil for first-person feel

4. AWP_Reload.blockyanim
   - Full reload animation (magazine swap)
   - Duration: 2.5-3.5 seconds
   - Sequence: mag release -> mag drop -> new mag insert -> bolt cycle
   - Bones involved: magazine (detach/reattach), bolt (cycle)

5. AWP_Reload_FPS.blockyanim
   - First-person version of the reload animation
   - Duration: 2.5-3.5 seconds

6. AWP_ADS.blockyanim
   - Aim Down Sights transition
   - Duration: 0.4 seconds
   - Weapon moves from hip to eye level/center screen

7. AWP_ADS_FPS.blockyanim
   - First-person ADS transition
   - Duration: 0.4 seconds
   - Weapon model repositions to center/scope view

Creation method:
- Open AWP_Model.blockymodel in Blockbench
- Use the Animation tab to create each animation
- Export each animation as .blockyanim using the Hytale plugin
- Ensure bone names match the model hierarchy:
  awp -> bolt -> trigger -> magazine

Animation tips:
- Shoot: Quick snap back (0-0.1s) then slow return (0.1-0.8s)
- Reload: Use keyframes at 0s, 0.5s, 1.5s, 2.0s, 2.5s
- Idle: Sine wave motion, very subtle (1-2 degree rotation)
- ADS: Smooth easing from hip position to centered aim
