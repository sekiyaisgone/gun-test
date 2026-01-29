AWP Weapon Texture - Required Image File
=========================================

Place the following .png file in this directory:

1. AWP_Texture.png
   - Main weapon texture for the AWP 3D model
   - Size: 128x128 pixels
   - Format: PNG (no transparency needed)
   - This texture maps to the UV layout defined in AWP_Model.blockymodel
   - Color scheme: Dark green/olive body, black barrel/scope,
     dark brown wooden stock details

The texture layout corresponds to the bone groups:
- awp (main body) - olive/dark green
- bolt (bolt mechanism) - dark metallic gray
- trigger (trigger group) - black/dark gray
- magazine (detachable mag) - dark green matching body

Generation method:
- Open AWP_Model.blockymodel in Blockbench
- Use the Paint tab to texture the model
- Export texture as 128x128 PNG
