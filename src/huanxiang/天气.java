package huanxiang;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.TextureAtlas;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import mindustry.Vars;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.gen.Sounds;
import mindustry.gen.WeatherState;
import mindustry.type.weather.ParticleWeather;

import static huanxiang.HXEffect.风暴声;

public class 天气 {
    public static class 风暴 extends ParticleWeather {
        TextureAtlas.AtlasRegion[] splashes = new TextureAtlas.AtlasRegion[0];
        private Color rainColor= Color.valueOf("7a95eaff");

        public 风暴(String name) {
            super(name);
            particleRegion= "particle";
                    xspeed= -8;
                    yspeed= -11;
                    color=Color.valueOf("a1b1d0");
                    drawNoise= false;
                    useWindVector= true;
                    sizeMin= 75;
                    sizeMax= 100;
                    minAlpha= 0.02f;
                    maxAlpha= 0.12f;
                    baseSpeed= 6.2f;
                    force= 1;

                    density= 20000;
                    padding= 16;

                    status= StatusEffects.wet;
                    sound =  Sounds.rain;
                    soundVol= 0.9f;
        }

        @Override
        public void load(){
            super.load();

            for (var i = 0; i < 12; i++) {
                splashes[i] = Core.atlas.find("splash-" + i);
            }
        }

        @Override
        public void drawOver(WeatherState state){

            drawRain(10f, 40f, 8f, 10f, 1000f, state.intensity, 0.85f,this.rainColor);

            if (Vars.state.isPlaying() && Mathf.chanceDelta(0.02 * state.intensity / 2)) {
                风暴声.at(Core.camera.position.x, Core.camera.position.y);
            }

            super.drawOver(state);
        }

        public void drawUnder(WeatherState state){
            drawSplashes((TextureRegion[]) splashes, 40F, 1100F, state.intensity, state.opacity, 18F, 0.75F, rainColor, Liquids.water);
        }
    }}