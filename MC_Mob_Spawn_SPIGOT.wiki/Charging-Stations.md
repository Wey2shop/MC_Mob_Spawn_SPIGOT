### Charging Stations are a 3x3/4 multiblock structures
3 on the <B>X</B> axis<BR>3 on the <b>Y</b> axis<BR>4 on the <b>Z</b> axis

You can Foillow this Guide to build one. 
Picture this as a 3 dimentional structure.<BR>
![image](https://github.com/Wey2shop/MC-SERVER-WIKI/assets/51450618/14878676-b900-4a6c-a9b4-38b59075da8d)
<BR>
**Step 1 Layer 1**<BR><BR>
`{GRAVEL}{GRAVEL}{GRAVEL} `<BR>
`{GRAVEL}{GRAVEL}{GRAVEL}`<BR>
`{GRAVEL}{GRAVEL}{GRAVEL}`<BR>
**Step 2 Layer 2**<BR><BR>
`{Lightning_Rod}{Lightning_Rod}{Lightning_Rod}`<BR>
`{Lightning_Rod}{Quatrz_block}{Lightning_Rod}`<BR>
`{Lightning_Rod}{Lightning_Rod}{Lightning_Rod}`<BR>
**Step 3 Layer 3**<BR><BR>
`{Lightning_Rod}{Lightning_Rod}{Lightning_Rod}`<BR>
`{Lightning_Rod}{Quatrz_block}{Lightning_Rod}`<BR>
`{Lightning_Rod}{Lightning_Rod}{Lightning_Rod}`<BR>
**Step 4 Layer 4**<BR><BR>
`{Daylight_detector}{Daylight_detector}{Daylight_detector}`<BR>
`{Daylight_detector}{REDSTONE_LAMP}{Daylight_detector}`<BR>
`{Daylight_detector}{Daylight_detector}{Daylight_detector}`<BR>

Then you just stand on the Redstone Block whilst holding a Redstone torch in your hand and your Battery power Will begin to recharge.
<BR>

###UPDATE: <BR>
I think this image is self explanatory, Same structure Diffrent core Differnt Charge rate
![image](https://github.com/Wey2shop/MC-SERVER-WIKI/assets/51450618/2f47f6be-7d6b-4226-88b0-fff048615c8b)
<BR>
You Could Even Embed it in the ground.
<LINE>
![image](https://github.com/Wey2shop/MC-SERVER-WIKI/assets/51450618/8b15ff2e-4ec1-4055-8a72-305cc7d71ce0)
<BR>


<details>
<summary>Technical Information</summary>
### In an RUA Block we run this;<BR>
`execute as @a[nbt={SelectedItem:{id:"minecraft:redstone_torch"}}] at @s if block ~ ~-1 ~ minecraft:redstone_lamp if block ~1 ~-1 ~ minecraft:daylight_detector if block ~-1 ~-1 ~ minecraft:daylight_detector if block ~ ~-1 ~1 minecraft:daylight_detector if block ~ ~-1 ~-1 minecraft:daylight_detector if block ~1 ~-1 ~ minecraft:daylight_detector if block ~1 ~-1 ~1 minecraft:daylight_detector if block ~1 ~-1 ~-1 minecraft:daylight_detector if block ~-1 ~-1 ~ minecraft:daylight_detector if block ~-1 ~-1 ~1 minecraft:daylight_detector if block ~-1 ~-1 ~-1 minecraft:daylight_detector if block ~ ~-2 ~ minecraft:quartz_block if block ~1 ~-2 ~ minecraft:lightning_rod if block ~-1 ~-2 ~ minecraft:lightning_rod if block ~ ~-2 ~1 minecraft:lightning_rod if block ~ ~-2 ~-1 minecraft:lightning_rod if block ~1 ~-2 ~ minecraft:lightning_rod if block ~1 ~-2 ~1 minecraft:lightning_rod if block ~1 ~-2 ~-1 minecraft:lightning_rod if block ~-1 ~-2 ~ minecraft:lightning_rod if block ~-1 ~-2 ~1 minecraft:lightning_rod if block ~-1 ~-2 ~-1 minecraft:lightning_rod if block ~ ~-3 ~ minecraft:quartz_block if block ~1 ~-3 ~ minecraft:lightning_rod if block ~-1 ~-3 ~ minecraft:lightning_rod if block ~ ~-3 ~1 minecraft:lightning_rod if block ~ ~-3 ~-1 minecraft:lightning_rod if block ~1 ~-3 ~ minecraft:lightning_rod if block ~1 ~-3 ~1 minecraft:lightning_rod if block ~1 ~-3 ~-1 minecraft:lightning_rod if block ~-1 ~-3 ~ minecraft:lightning_rod if block ~-1 ~-3 ~1 minecraft:lightning_rod if block ~-1 ~-3 ~-1 minecraft:lightning_rod if block ~ ~-4 ~ minecraft:gravel if block ~1 ~-4 ~ minecraft:gravel if block ~-1 ~-4 ~ minecraft:gravel if block ~ ~-4 ~1 minecraft:gravel if block ~ ~-4 ~-1 minecraft:gravel if block ~1 ~-4 ~ minecraft:gravel if block ~1 ~-4 ~1 minecraft:gravel if block ~1 ~-4 ~-1 minecraft:gravel if block ~-1 ~-4 ~ minecraft:gravel if block ~-1 ~-4 ~1 minecraft:gravel if block ~-1 ~-4 ~-1 minecraft:gravel at @s positioned ~ ~10 ~ run scoreboard players add @p BattPOW 2?`

To make life easier i made a command Generator
https://mc124.w3spaces.com/MC1.2.html
