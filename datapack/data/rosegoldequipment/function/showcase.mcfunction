# Rose Gold Equipment visual check. Run in a Creative world: /function rosegoldequipment:showcase
# Look for: purple/black textures, missing trims, wrong colours. Builds east (+X) of where you stand.
fill ~-1 ~-1 ~-2 ~40 ~-1 ~10 minecraft:smooth_stone
fill ~-1 ~ ~-2 ~40 ~4 ~10 minecraft:air
kill @e[type=minecraft:armor_stand,distance=..60]
# Row 1: vanilla armor with a rose gold trim
summon minecraft:armor_stand ~0 ~ ~0 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"leather + rose gold trim",Rotation:[180f,0f],equipment:{head:{id:"minecraft:leather_helmet",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},chest:{id:"minecraft:leather_chestplate",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},legs:{id:"minecraft:leather_leggings",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},feet:{id:"minecraft:leather_boots",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}}}}
summon minecraft:armor_stand ~3 ~ ~0 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"chainmail + rose gold trim",Rotation:[180f,0f],equipment:{head:{id:"minecraft:chainmail_helmet",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},chest:{id:"minecraft:chainmail_chestplate",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},legs:{id:"minecraft:chainmail_leggings",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},feet:{id:"minecraft:chainmail_boots",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}}}}
summon minecraft:armor_stand ~6 ~ ~0 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"iron + rose gold trim",Rotation:[180f,0f],equipment:{head:{id:"minecraft:iron_helmet",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},chest:{id:"minecraft:iron_chestplate",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},legs:{id:"minecraft:iron_leggings",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},feet:{id:"minecraft:iron_boots",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}}}}
summon minecraft:armor_stand ~9 ~ ~0 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"golden + rose gold trim",Rotation:[180f,0f],equipment:{head:{id:"minecraft:golden_helmet",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},chest:{id:"minecraft:golden_chestplate",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},legs:{id:"minecraft:golden_leggings",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},feet:{id:"minecraft:golden_boots",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}}}}
summon minecraft:armor_stand ~12 ~ ~0 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"diamond + rose gold trim",Rotation:[180f,0f],equipment:{head:{id:"minecraft:diamond_helmet",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},chest:{id:"minecraft:diamond_chestplate",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},legs:{id:"minecraft:diamond_leggings",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},feet:{id:"minecraft:diamond_boots",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}}}}
summon minecraft:armor_stand ~15 ~ ~0 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"netherite + rose gold trim",Rotation:[180f,0f],equipment:{head:{id:"minecraft:netherite_helmet",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},chest:{id:"minecraft:netherite_chestplate",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},legs:{id:"minecraft:netherite_leggings",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},feet:{id:"minecraft:netherite_boots",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}}}}
summon minecraft:armor_stand ~18 ~ ~0 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"copper + rose gold trim",Rotation:[180f,0f],equipment:{head:{id:"minecraft:copper_helmet",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},chest:{id:"minecraft:copper_chestplate",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},legs:{id:"minecraft:copper_leggings",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}},feet:{id:"minecraft:copper_boots",count:1,components:{"minecraft:trim":{material:"rosegoldequipment:rose_gold",pattern:"minecraft:coast"}}}}}
# Row 2: rose gold armor, untrimmed and with every trim material
summon minecraft:armor_stand ~0 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold, no trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~3 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + rose gold trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/rose_gold
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/rose_gold
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/rose_gold
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/rose_gold
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~6 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + quartz trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/quartz
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/quartz
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/quartz
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/quartz
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~9 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + iron trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/iron
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/iron
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/iron
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/iron
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~12 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + netherite trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/netherite
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/netherite
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/netherite
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/netherite
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~15 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + redstone trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/redstone
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/redstone
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/redstone
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/redstone
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~18 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + copper trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/copper
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/copper
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/copper
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/copper
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~21 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + gold trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/gold
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/gold
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/gold
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/gold
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~24 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + emerald trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/emerald
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/emerald
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/emerald
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/emerald
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~27 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + diamond trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/diamond
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/diamond
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/diamond
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/diamond
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~30 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + lapis trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/lapis
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/lapis
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/lapis
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/lapis
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~33 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + amethyst trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/amethyst
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/amethyst
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/amethyst
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/amethyst
tag @n[tag=rge_new] remove rge_new
summon minecraft:armor_stand ~36 ~ ~6 {NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"rose gold + resin trim",Rotation:[180f,0f],Tags:["rge_new"]}
loot replace entity @n[tag=rge_new] armor.head loot rosegoldequipment:item/rose_golden_helmet
item modify entity @n[tag=rge_new] armor.head rosegoldequipment:trim/resin
loot replace entity @n[tag=rge_new] armor.chest loot rosegoldequipment:item/rose_golden_chestplate
item modify entity @n[tag=rge_new] armor.chest rosegoldequipment:trim/resin
loot replace entity @n[tag=rge_new] armor.legs loot rosegoldequipment:item/rose_golden_leggings
item modify entity @n[tag=rge_new] armor.legs rosegoldequipment:trim/resin
loot replace entity @n[tag=rge_new] armor.feet loot rosegoldequipment:item/rose_golden_boots
item modify entity @n[tag=rge_new] armor.feet rosegoldequipment:trim/resin
tag @n[tag=rge_new] remove rge_new
# Every item
clear @s
function rosegoldequipment:give_all
give @s minecraft:coast_armor_trim_smithing_template 4
give @s minecraft:smithing_table
tellraw @s {"text":"Rose Gold showcase built. Check every armor stand and your inventory icons.","color":"#FFBBB6"}
