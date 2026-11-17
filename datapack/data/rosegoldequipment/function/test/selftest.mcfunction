# Used by the automatic test (GitHub Actions). Harmless to run yourself.
forceload add 0 0
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_gold_ingot
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:command_block",components:{"minecraft:item_model":"rosegoldequipment:rose_gold_ingot"}}}] run say SELFTEST-OK rose_gold_ingot
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_gold_nugget
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:chain_command_block",components:{"minecraft:item_model":"rosegoldequipment:rose_gold_nugget"}}}] run say SELFTEST-OK rose_gold_nugget
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/raw_rose_gold
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:repeating_command_block",components:{"minecraft:item_model":"rosegoldequipment:raw_rose_gold"}}}] run say SELFTEST-OK raw_rose_gold
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_gilded_beetroot
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:structure_block",components:{"minecraft:item_model":"rosegoldequipment:rose_gilded_beetroot"}}}] run say SELFTEST-OK rose_gilded_beetroot
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_gilded_mushroom
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:jigsaw",components:{"minecraft:item_model":"rosegoldequipment:rose_gilded_mushroom"}}}] run say SELFTEST-OK rose_gilded_mushroom
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_gilded_cookie
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:test_instance_block",components:{"minecraft:item_model":"rosegoldequipment:rose_gilded_cookie"}}}] run say SELFTEST-OK rose_gilded_cookie
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rosey_beetroot_stew
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:test_instance_block",components:{"minecraft:item_model":"rosegoldequipment:rosey_beetroot_stew"}}}] run say SELFTEST-OK rosey_beetroot_stew
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_mushroom_omelette
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:test_instance_block",components:{"minecraft:item_model":"rosegoldequipment:rose_mushroom_omelette"}}}] run say SELFTEST-OK rose_mushroom_omelette
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_mushroom_partial
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:test_instance_block",components:{"minecraft:item_model":"rosegoldequipment:rose_mushroom_partial"}}}] run say SELFTEST-OK rose_mushroom_partial
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_mushroom_crumbs
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:test_instance_block",components:{"minecraft:item_model":"rosegoldequipment:rose_mushroom_crumbs"}}}] run say SELFTEST-OK rose_mushroom_crumbs
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_full_jelly
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:test_instance_block",components:{"minecraft:item_model":"rosegoldequipment:rose_full_jelly"}}}] run say SELFTEST-OK rose_full_jelly
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_half_jelly
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:test_instance_block",components:{"minecraft:item_model":"rosegoldequipment:rose_half_jelly"}}}] run say SELFTEST-OK rose_half_jelly
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_sword
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_sword",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_sword"}}}] run say SELFTEST-OK rose_golden_sword
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_spear
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_spear",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_spear"}}}] run say SELFTEST-OK rose_golden_spear
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_pickaxe
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_pickaxe",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_pickaxe"}}}] run say SELFTEST-OK rose_golden_pickaxe
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_shovel
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_shovel",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_shovel"}}}] run say SELFTEST-OK rose_golden_shovel
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_axe
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_axe",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_axe"}}}] run say SELFTEST-OK rose_golden_axe
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_hoe
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_hoe",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_hoe"}}}] run say SELFTEST-OK rose_golden_hoe
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_helmet
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_helmet",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_helmet"}}}] run say SELFTEST-OK rose_golden_helmet
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_chestplate
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_chestplate",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_chestplate"}}}] run say SELFTEST-OK rose_golden_chestplate
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_leggings
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_leggings",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_leggings"}}}] run say SELFTEST-OK rose_golden_leggings
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
execute positioned 0 100 0 run loot spawn ~ ~ ~ loot rosegoldequipment:item/rose_golden_boots
execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={Item:{id:"minecraft:iron_boots",components:{"minecraft:item_model":"rosegoldequipment:rose_golden_boots"}}}] run say SELFTEST-OK rose_golden_boots
kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]
forceload remove 0 0
say SELFTEST-DONE 22
