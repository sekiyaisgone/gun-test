AWP Sound Effects - Required Audio Files
=========================================

Place the following .ogg audio files in this directory:

1. awp_shoot.ogg
   - AWP gunshot/firing sound effect
   - Recommendation: Deep, powerful sniper rifle report
   - Duration: ~0.5-1.0 seconds
   - Sample rate: 44100 Hz, mono or stereo

2. awp_reload.ogg
   - Magazine swap and bolt cycling reload sound
   - Duration: ~2.5 seconds
   - Should include: magazine release click, magazine insertion,
     bolt pull-back, bolt release forward

3. awp_bolt.ogg
   - Bolt action cycling sound (used after each shot)
   - Duration: ~0.8 seconds
   - Should include: bolt lift, pull-back, push-forward, lock-down

4. awp_empty.ogg
   - Dry fire / empty chamber click
   - Duration: ~0.2 seconds
   - Should be a metallic click sound

Source suggestions:
- Freesound.org (CC0/CC-BY licensed sounds)
- Record custom sounds
- Use sound design software (Audacity, FL Studio)

All files must be in OGG Vorbis format (.ogg).
Convert from WAV/MP3 using: ffmpeg -i input.wav -c:a libvorbis -q:a 5 output.ogg
